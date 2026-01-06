import express from "express";
import { connect } from "mongoose";
import dotenv from "dotenv";
import cors from "cors";
import userRoutes from "./src/routes/user.route.js";
import path from "path";
dotenv.config();
const app = express();

app.use(
  cors({
    origin: "http://localhost:5173",
    credentials: true,
  })
);

app.use(express.json());

// Routes
app.use("/api/users", userRoutes);

// MongoDB connection
connect(process.env.MONGO_URI)
  .then(() => console.log("MongoDB connected"))
  .catch((err) => console.error(err));

const __dirname = path.resolve();
app.use(express.static(path.join(__dirname, "/client/dist")));
app.get("/*", (req, res) => {
  res.sendFile(path.join(__dirname, "client", "dist", "index.html"));
});

app.listen(5000, () => console.log("Server running on port 5000"));
