import User from "../models/user.model.js";
import { genSalt, hash, compare } from "bcryptjs";

const createUser = async (data) => {
  // hash password
  const salt = await genSalt(10);
  const hashedPassword = await hash(data.password, salt);

  const user = new User({
    name: data.name,
    email: data.email,
    mobile: data.mobile,
    password: hashedPassword,
  });

  return await user.save();
};

const getAllUsers = async () => {
  return await find().select("-password");
};

const findByEmail = async (email) => {
  return await findOne({ email });
};
const getUserById = async (id) => {
  return await findById(id).select("-password");
};

const createGoogleUser = async ({ name, email }) => {
  return await create({
    name,
    email,
    mobile: "",
    password: "",
  });
};

const comparePassword = async (plain, hashed) => {
  return compare(plain, hashed);
};

export default {
  createUser,
  getAllUsers,
  getUserById,
  createGoogleUser,
  findByEmail,
  comparePassword,
};
