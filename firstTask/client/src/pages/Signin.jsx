import { GoogleOAuthProvider, GoogleLogin } from "@react-oauth/google";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { jwtDecode } from "jwt-decode";
import api from "../config/axios";
function Signin() {
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);
  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSignin = async () => {
    try {
      const res = await api.post("/users/login", formData);

      console.log("Signin success:", res.data);
      // store token / redirect
      localStorage.setItem("token", res.data.token);
      localStorage.setItem("user", JSON.stringify(res.data.user));
      navigate("/");
    } catch (err) {
      alert(err.response?.data?.message || "Signin failed");
    }
  };

  const googleHandler = async (credentialResponse) => {
    try {
      const res = await api.post("/users/googleLogin", {
        credential: credentialResponse.credential,
      });

      console.log("Google signup/login success:", res.data);
      // store token / redirect
      // store token / redirect
      localStorage.setItem("token", res.data.token);
      localStorage.setItem("user", JSON.stringify(res.data.user));
      navigate("/");
    } catch (err) {
      alert(
        err.response?.data?.message || "Google login failed. Please try again."
      );
    }
  };

  const handleSuccess = async (response) => {
    try {
      const { credential } = response;
      const userInfo = jwtDecode(credential);
      const { name, email: googleEmail, sub: googleUserId, picture } = userInfo;
      console.log(userInfo);

      const res = await api.post(`/users/googleLogin`, userInfo);
      console.log(res);
      console.log("success");
      localStorage.setItem("token", res.data.token);
      localStorage.setItem("user", JSON.stringify(res.data.user));
      console.log("User is fetched proceed to home");
      navigate("/");
    } catch (error) {
      console.error("Google login error:", error);
    }
  };

  const showError = (msg) => {
    alert(msg);
  };
  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-100 px-4">
      <div className="w-full max-w-md bg-white rounded-lg shadow-lg p-6">
        <h2 className="text-2xl font-bold text-center mb-6">Sign In</h2>

        {/* Email */}
        <div className="mb-4">
          <label className="block text-sm font-medium mb-1">Email</label>
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Enter email"
            className="w-full border rounded-md px-3 py-2 focus:outline-none focus:ring-2 focus:ring-black"
          />
        </div>

        {/* Password */}
        <div className="mb-2">
          <label className="block text-sm font-medium mb-1">Password</label>
          <div className="relative">
            <input
              type={showPassword ? "text" : "password"}
              placeholder="Enter password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              className="w-full border rounded-md px-3 py-2 pr-10 focus:outline-none focus:ring-2 focus:ring-black"
            />
            <button
              type="button"
              className="absolute right-3 top-2.5 text-sm text-gray-600"
              onClick={() => setShowPassword(!showPassword)}
            >
              {showPassword ? "Hide" : "Show"}
            </button>
          </div>
        </div>

        {/* Forgot password */}
        <div className="text-right mb-4">
          <a
            href="/forgot-password"
            className="text-sm text-blue-600 hover:underline"
          >
            Forgot password?
          </a>
        </div>

        {/* Sign In Button */}
        <button
          onClick={handleSignin}
          className="w-full bg-black text-white py-2 rounded-md hover:bg-gray-800 transition"
        >
          Sign In
        </button>

        {/* Divider */}
        <div className="flex items-center my-5">
          <div className="flex-1 h-px bg-gray-300" />
          <span className="px-3 text-sm text-gray-500">OR</span>
          <div className="flex-1 h-px bg-gray-300" />
        </div>

        {/* Google Login */}
        <GoogleOAuthProvider clientId="526992097258-an7ps4j6qetf8mcjcd0g0d8deok1lmsf.apps.googleusercontent.com">
          <GoogleLogin
            onSuccess={handleSuccess}
            onError={() => showError("Google login failed. Please try again.")}
            text="continue_with"
            size="large"
            width="100%"
          />
        </GoogleOAuthProvider>

        {/* Create account */}
        <p className="text-center text-sm mt-6">
          Don’t have an account?{" "}
          <a href="/signup" className="text-blue-600 hover:underline">
            Create account
          </a>
        </p>
      </div>
    </div>
  );
}

export default Signin;

//
