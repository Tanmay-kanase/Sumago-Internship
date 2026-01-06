import React, { useState, useEffect, useRef } from "react";

// --- CONFIGURATION ---
const API_KEY = import.meta.env.VITE_GEMINI_API_KEY;
const API_URL =
  "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash-preview-09-2025:generateContent";

const SYSTEM_INSTRUCTION = `
You are a helpful AI assistant.
Answer clearly and concisely.
`;

// --- SOURCE TYPE ---
const extractSources = (candidate) => {
  const groundingMetadata = candidate?.groundingMetadata;
  if (!groundingMetadata?.groundingAttributions) return [];

  return groundingMetadata.groundingAttributions
    .map((attr) => ({
      uri: attr?.web?.uri,
      title: attr?.web?.title,
    }))
    .filter((s) => s.uri && s.title);
};

const Chat = () => {
  const [messages, setMessages] = useState([
    { role: "ai", text: "How can I assist you today?" },
  ]);
  const [input, setInput] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const scrollRef = useRef(null);

  // Auto-scroll
  useEffect(() => {
    scrollRef.current?.scrollIntoView({ behavior: "smooth" });
  }, [messages]);

  // --- GEMINI API CALL LOGIC (same as Flutter) ---
  const generateContent = async (userQuery) => {
    setIsLoading(true);

    const payload = {
      contents: [
        {
          parts: [{ text: userQuery }],
        },
      ],
      tools: [{ google_search: {} }],
      systemInstruction: {
        parts: [{ text: SYSTEM_INSTRUCTION }],
      },
    };

    const url = `${API_URL}?key=${API_KEY}`;

    try {
      // Exponential backoff (3 tries)
      for (let i = 0; i < 3; i++) {
        const response = await fetch(url, {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(payload),
        });

        if (response.ok) {
          const result = await response.json();
          const candidate = result?.candidates?.[0];

          if (candidate) {
            const text =
              candidate?.content?.parts?.[0]?.text ||
              "Could not generate a response.";

            const sources = extractSources(candidate);

            setMessages((prev) => [...prev, { role: "ai", text, sources }]);
          } else {
            setMessages((prev) => [
              ...prev,
              { role: "ai", text: "Error: No candidate response found." },
            ]);
          }
          break; // success
        }

        // Retry on 429
        if (response.status === 429 && i < 2) {
          const delay = 1000 * 2 ** i;
          await new Promise((r) => setTimeout(r, delay));
          continue;
        }

        // Other errors
        const errText = await response.text();
        setMessages((prev) => [
          ...prev,
          {
            role: "ai",
            text: `API Error: ${response.status} - ${errText}`,
          },
        ]);
        break;
      }
    } catch (e) {
      setMessages((prev) => [
        ...prev,
        { role: "ai", text: `Network/Parsing Error: ${e.message}` },
      ]);
    } finally {
      setIsLoading(false);
    }
  };

  // --- SEND HANDLER ---
  const handleSendMessage = async (e) => {
    e.preventDefault();
    if (!input.trim() || isLoading) return;

    const userMessage = { role: "user", text: input };
    setMessages((prev) => [...prev, userMessage]);

    const query = input;
    setInput("");

    await generateContent(query);
  };

  return (
    <div className="flex flex-col h-screen bg-slate-50 p-4 sm:p-6">
      <div className="max-w-4xl w-full mx-auto flex flex-col flex-grow bg-white rounded-2xl shadow-xl overflow-hidden border border-slate-200">
        {/* Header */}
        <div className="bg-indigo-600 p-4 text-white flex items-center gap-3">
          <div className="w-10 h-10 rounded-full bg-white/20 flex items-center justify-center font-bold">
            G
          </div>
          <div>
            <h1 className="font-semibold text-lg">Gemini Assistant</h1>
            <p className="text-xs text-indigo-100">Always active</p>
          </div>
        </div>

        {/* Chat Area */}
        <div className="flex-grow overflow-y-auto p-4 space-y-4 bg-slate-50/50">
          {messages.map((msg, index) => (
            <div
              key={index}
              className={`flex ${
                msg.role === "user" ? "justify-end" : "justify-start"
              }`}
            >
              <div
                className={`max-w-[80%] px-4 py-2 rounded-2xl text-sm md:text-base ${
                  msg.role === "user"
                    ? "bg-indigo-600 text-white rounded-tr-none"
                    : "bg-white text-slate-800 shadow-sm border border-slate-200 rounded-tl-none"
                }`}
              >
                {msg.text}

                {/* Grounding sources */}
                {msg.sources?.length > 0 && (
                  <div className="mt-2 text-xs text-slate-500 space-y-1">
                    <div className="font-semibold">Sources:</div>
                    {msg.sources.map((s, i) => (
                      <div key={i}>
                        <a
                          href={s.uri}
                          target="_blank"
                          rel="noreferrer"
                          className="underline"
                        >
                          {s.title}
                        </a>
                      </div>
                    ))}
                  </div>
                )}
              </div>
            </div>
          ))}

          {isLoading && (
            <div className="flex justify-start">
              <div className="bg-white px-4 py-2 rounded-2xl shadow-sm border border-slate-200 animate-pulse text-slate-400">
                Gemini is thinking...
              </div>
            </div>
          )}

          <div ref={scrollRef} />
        </div>

        {/* Input Area */}
        <form
          onSubmit={handleSendMessage}
          className="p-4 bg-white border-t border-slate-200 flex gap-2"
        >
          <input
            type="text"
            value={input}
            onChange={(e) => setInput(e.target.value)}
            placeholder="Ask me anything..."
            className="flex-grow px-4 py-3 bg-slate-100 rounded-xl focus:outline-none focus:ring-2 focus:ring-indigo-500 transition-all text-slate-700"
          />
          <button
            type="submit"
            disabled={isLoading}
            className="bg-indigo-600 hover:bg-indigo-700 disabled:bg-indigo-300 text-white px-6 py-2 rounded-xl font-medium transition-colors"
          >
            Send
          </button>
        </form>
      </div>
    </div>
  );
};

export default Chat;
