function App() {
  return (
    <div
      style={{
        background: "#020617",
        minHeight: "100vh",
        color: "white",
        padding: "30px 20px",
        fontFamily: "Arial, sans-serif",
      }}
    >
      <div
        style={{
          maxWidth: "1100px",
          margin: "0 auto",
        }}
      >
        <h1
          style={{
            textAlign: "center",
            fontSize: "clamp(32px, 6vw, 64px)",
            marginBottom: "20px",
            lineHeight: "1.2",
          }}
        >
          Fitness Tracker Backend API
        </h1>

        <p
          style={{
            textAlign: "center",
            color: "#cbd5e1",
            fontSize: "clamp(16px, 3vw, 22px)",
            lineHeight: "1.8",
            maxWidth: "900px",
            margin: "0 auto",
          }}
        >
          Production-ready backend application built using Spring Boot,
          JWT Authentication, PostgreSQL, Swagger, Docker and Render Deployment.
        </p>

        <div
          style={{
            display: "flex",
            gap: "20px",
            flexWrap: "wrap",
            justifyContent: "center",
            marginTop: "50px",
          }}
        >
          {[
            "JWT Authentication",
            "Spring Security",
            "REST APIs",
            "PostgreSQL",
            "Swagger Docs",
            "Docker",
            "Render Deployment",
          ].map((item) => (
            <div
              key={item}
              style={{
                background: "#0f172a",
                border: "1px solid #1e293b",
                padding: "20px",
                borderRadius: "12px",
                minWidth: "220px",
                textAlign: "center",
                boxShadow: "0 4px 10px rgba(0,0,0,0.3)",
              }}
            >
              {item}
            </div>
          ))}
        </div>

        <div
          style={{
            marginTop: "60px",
            display: "flex",
            gap: "20px",
            flexWrap: "wrap",
            justifyContent: "center",
          }}
        >
          <a
            href="https://fitness-track-backend-vcwk.onrender.com/swagger-ui/index.html"
            target="_blank"
            rel="noreferrer"
            style={{
              background: "#2563eb",
              color: "white",
              padding: "15px 25px",
              textDecoration: "none",
              borderRadius: "10px",
              fontWeight: "bold",
            }}
          >
            Swagger API Docs
          </a>

          <a
            href="https://github.com/pragya638/fitness-tracker-backend"
            target="_blank"
            rel="noreferrer"
            style={{
              background: "#16a34a",
              color: "white",
              padding: "15px 25px",
              textDecoration: "none",
              borderRadius: "10px",
              fontWeight: "bold",
            }}
          >
            GitHub Repository
          </a>
        </div>

        <div
          style={{
            textAlign: "center",
            marginTop: "80px",
            color: "#94a3b8",
          }}
        >
          Developed by Pragya Dwivedi
        </div>
      </div>
    </div>
  );
}

export default App;