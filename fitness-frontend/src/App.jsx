function App() {
  return (
    <div
      style={{
        background: "#0f172a",
        minHeight: "100vh",
        color: "white",
        padding: "20px",
        fontFamily: "Arial, sans-serif",
        boxSizing: "border-box",
      }}
    >
      <h1
        style={{
          fontSize: "clamp(32px, 8vw, 64px)",
          marginBottom: "20px",
          textAlign: "center",
          wordBreak: "break-word",
        }}
      >
        Fitness Tracker Backend API
      </h1>

      <p
        style={{
          fontSize: "clamp(16px, 4vw, 24px)",
          maxWidth: "900px",
          lineHeight: "1.7",
          color: "#cbd5e1",
          margin: "0 auto",
          textAlign: "center",
        }}
      >
        Production-ready backend application built using Spring Boot,
        JWT Authentication, PostgreSQL, Swagger, Docker, and Render
        Deployment.
      </p>

      <hr style={{ margin: "40px 0" }} />

      <h2
        style={{
          textAlign: "center",
        }}
      >
        Core Features
      </h2>

      <ul
        style={{
          lineHeight: "2",
          fontSize: "clamp(16px, 3vw, 20px)",
          maxWidth: "500px",
          margin: "0 auto",
        }}
      >
        <li>JWT Authentication</li>
        <li>Spring Security</li>
        <li>REST APIs</li>
        <li>PostgreSQL Database</li>
        <li>Swagger Documentation</li>
        <li>Docker Deployment</li>
        <li>Cloud Deployment on Render</li>
      </ul>

      <hr style={{ margin: "40px 0" }} />

      <h2
        style={{
          textAlign: "center",
        }}
      >
        Project Links
      </h2>

      <div
        style={{
          marginTop: "30px",
          display: "flex",
          flexWrap: "wrap",
          gap: "15px",
          justifyContent: "center",
        }}
      >
        <a
          href="https://fitness-track-backend-vcwk.onrender.com/swagger-ui/index.html"
          target="_blank"
          rel="noreferrer"
          style={{
            display: "inline-block",
            padding: "14px 24px",
            background: "#2563eb",
            color: "white",
            textDecoration: "none",
            borderRadius: "10px",
            fontSize: "18px",
          }}
        >
          Swagger API Docs
        </a>

        <a
          href="https://github.com/pragya638/fitness-tracker-backend"
          target="_blank"
          rel="noreferrer"
          style={{
            display: "inline-block",
            padding: "14px 24px",
            background: "#16a34a",
            color: "white",
            textDecoration: "none",
            borderRadius: "10px",
            fontSize: "18px",
          }}
        >
          GitHub Repository
        </a>
      </div>

      <hr style={{ margin: "50px 0" }} />

      <p
        style={{
          color: "#94a3b8",
          marginTop: "40px",
          fontSize: "18px",
          textAlign: "center",
        }}
      >
        Developed by Pragya Dwivedi
      </p>
    </div>
  );
}

export default App;