import userService from "../services/user.service.js";
import jwt from "jsonwebtoken";

export const createUser = async (req, res) => {
  try {
    const user = await userService.createUser(req.body);

    // Use this instead of the hardcoded string
    const token = jwt.sign(
      { id: user._id, email: user.email },
      process.env.SECRET_KEY, // Matches your middleware logic
      { expiresIn: "7d" }
    );

    res.status(201).json({
      message: "User created successfully",
      token,
      user: {
        id: user._id,
        name: user.name,
        email: user.email,
        mobile: user.mobile,
      },
    });
  } catch (err) {
    res.status(400).json({ message: err.message });
  }
};

export const googleLogin = async (req, res) => {
  try {
    const { email, name } = req.body;

    if (!email) {
      return res.status(400).json({ message: "Email is required" });
    }

    let user = await userService.findByEmail(email);
    if (!user) {
      user = await userService.createGoogleUser({
        name: name || "Google User",
        email,
      });
    }

    const token = sign({ id: user._id, email: user.email }, "SECRET_KEY", {
      expiresIn: "7d",
    });

    res.json({
      message: "Google login successful",
      token,
      user: {
        id: user._id,
        name: user.name,
        email: user.email,
        mobile: user.mobile,
      },
    });
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
};

export const loginUser = async (req, res) => {
  try {
    const { email, password } = req.body;

    // 1. Validate input
    if (!email || !password) {
      return res
        .status(400)
        .json({ message: "Email and password are required" });
    }

    // 2. Find user
    const user = await userService.findByEmail(email);
    if (!user) {
      return res.status(401).json({ message: "Invalid email or password" });
    }

    // 3. Google user check (no password set)
    if (!user.password) {
      return res.status(400).json({
        message:
          "This account was created using Google. Please sign in with Google or set a password from profile.",
      });
    }

    // 4. Compare password
    const isMatch = await userService.comparePassword(password, user.password);

    if (!isMatch) {
      return res.status(401).json({ message: "Invalid email or password" });
    }

    // 5. Generate token
    const token = sign({ id: user._id, email: user.email }, "SECRET_KEY", {
      expiresIn: "7d",
    });

    // 6. Send response
    res.json({
      message: "Login successful",
      token,
      user: {
        id: user._id,
        name: user.name,
        email: user.email,
        mobile: user.mobile,
      },
    });
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
};

export const getUsers = async (req, res) => {
  const users = await userService.getAllUsers();
  res.json(users);
};

export const getUser = async (req, res) => {
  const user = await userService.getUserById(req.params.id);
  res.json(user);
};
