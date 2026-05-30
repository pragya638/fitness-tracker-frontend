function App() {
  const features = [
    "JWT Authentication",
    "Spring Security",
    "REST APIs",
    "PostgreSQL",
    "Swagger Docs",
    "Docker",
    "Render Deployment",
  ];

  return (
    <div
      style={{
        minHeight: "100vh",
        background:
          "linear-gradient(135deg, #020617 0%, #0f172a 50%, #1e293b 100%)",
        color: "white",
        padding: "40px 20px",
        fontFamily: "Arial, sans-serif",
      }}
    >
      <div
        style={{
          maxWidth: "1100px",
          margin: "0 auto",
          textAlign: "center",
        }}
      >
        <h1
          style={{
            fontSize: "clamp(36px, 6vw, 72px)",
            fontWeight: "700",
            marginBottom: "20px",
            color: "#ffffff",
            lineHeight: "1.2",
          }}
        >
          Fitness Tracker Backend API
        </h1>

        <p
          style={{
            fontSize: "clamp(18px, 2vw, 26px)",
            color: "#cbd5e1",
            lineHeight: "1.8",
            maxWidth: "900px",
            margin: "0 auto",
          }}
        >
          Production-ready backend application built using Spring Boot, JWT
          Authentication, PostgreSQL, Swagger, Docker and Render Deployment.
        </p>

        <div
          style={{
            display: "grid",
            gridTemplateColumns:
              "repeat(auto-fit, minmax(220px, 1fr))",
            gap: "20px",
            marginTop: "60px",
          }}
        >
          {features.map((feature) => (
            <div
              key={feature}
              style={{
                background: "#0f172a",
                padding: "24px",
                borderRadius: "18px",
                border: "1px solid rgba(255,255,255,0.08)",
                boxShadow: "0 8px 25px rgba(0,0,0,0.3)",
                fontSize: "22px",
                fontWeight: "500",
              }}
            >
              {feature}
            </div>
          ))}
        </div>

        <div
          style={{
            marginTop: "60px",
            display: "flex",
            flexWrap: "wrap",
            justifyContent: "center",
            gap: "20px",
          }}
        >
          <a
            href="https://fitness-track-backend-vcwk.onrender.com/swagger-ui/index.html"
            target="_blank"
            rel="noreferrer"
            style={{
              background: "#2563eb",
              color: "white",
              padding: "16px 30px",
              borderRadius: "12px",
              textDecoration: "none",
              fontSize: "18px",
              fontWeight: "600",
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
              padding: "16px 30px",
              borderRadius: "12px",
              textDecoration: "none",
              fontSize: "18px",
              fontWeight: "600",
            }}
          >
            GitHub Repository
          </a>
        </div>

        <p
          style={{
            marginTop: "80px",
            color: "#94a3b8",
            fontSize: "18px",
          }}
        >
          Developed by Pragya Dwivedi
        </p>
      </div>
    </div>
  );
}

export default App;