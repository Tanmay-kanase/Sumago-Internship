import { Router } from "express";
const userRoutes = Router();
import { createUser, googleLogin, getUsers, getUser, loginUser } from "../controller/user.controller.js";
import verifyToken from "../middleware/auth.middleware.js";

userRoutes.post("/", createUser);
userRoutes.post("/googleLogin", googleLogin);
userRoutes.get("/", verifyToken, getUsers);
userRoutes.get("/:id", verifyToken, getUser);
userRoutes.post("/login", loginUser);
export default userRoutes;
