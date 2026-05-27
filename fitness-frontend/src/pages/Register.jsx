import { Link } from "react-router-dom";

function Register() {
  return (
    <div
      style={{
        minHeight: "100vh",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        background: "#0f172a",
        color: "white",
      }}
    >
      <div>
        <h1>Register Page</h1>

        <Link to="/">
          <button
            style={{
              padding: "10px 20px",
              marginTop: "20px",
              cursor: "pointer",
            }}
          >
            Go to Login
          </button>
        </Link>
      </div>
    </div>
  );
}

export default Register;