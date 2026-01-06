import React from "react";

function Navbar() {
  return (
    <nav className="bg-black text-white px-4 py-3">
      <div className="flex items-center justify-between">
        {/* Logo */}
        <h1 className="text-xl font-bold">MyApp</h1>

        {/* Desktop Menu */}
        <ul className="hidden md:flex gap-6">
          <li className="cursor-pointer hover:text-gray-300">Home</li>
          <li className="cursor-pointer hover:text-gray-300">About</li>
          <li className="cursor-pointer hover:text-gray-300">Services</li>
          <li className="cursor-pointer hover:text-gray-300">Contact</li>
        </ul>

        {/* Mobile Button */}
        <button
          className="md:hidden text-2xl"
          onClick={() => {
            document.getElementById("mobile-menu").classList.toggle("hidden");
          }}
        >
          ☰
        </button>
      </div>

      {/* Mobile Menu */}
      <ul id="mobile-menu" className="hidden md:hidden mt-4 space-y-3">
        <li className="cursor-pointer hover:text-gray-300">Home</li>
        <li className="cursor-pointer hover:text-gray-300">About</li>
        <li className="cursor-pointer hover:text-gray-300">Services</li>
        <li className="cursor-pointer hover:text-gray-300">Contact</li>
      </ul>
    </nav>
  );
}

export default Navbar;
