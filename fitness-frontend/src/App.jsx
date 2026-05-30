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
        background: "#020617",
        minHeight: "100vh",
        color: "#ffffff",
        padding: "30px 20px",
        fontFamily: "Arial, sans-serif",
      }}
    >
      <div
        style={{
          maxWidth: "1200px",
          margin: "0 auto",
        }}
      >
        <h1
          style={{
            textAlign: "center",
            color: "#ffffff",
            fontSize: "clamp(32px, 6vw, 64px)",
            lineHeight: "1.2",
            marginBottom: "25px",
          }}
        >
          Fitness Tracker Backend API
        </h1>

        <p
          style={{
            textAlign: "center",
            color: "#cbd5e1",
            fontSize: "clamp(16px, 2.5vw, 24px)",
            lineHeight: "1.8",
            maxWidth: "900px",
            margin: "0 auto",
          }}
        >
          Production-ready backend application built using Spring Boot,
          JWT Authentication, PostgreSQL, Swagger, Docker and Render
          Deployment.
        </p>

        <div
          style={{
            marginTop: "60px",
            display: "grid",
            gridTemplateColumns: "repeat(auto-fit, minmax(220px, 1fr))",
            gap: "20px",
          }}
        >
          {features.map((feature) => (
            <div
              key={feature}
              style={{
                background: "#0f172a",
                border: "1px solid #1e293b",
                borderRadius: "14px",
                padding: "24px",
                textAlign: "center",
                fontSize: "22px",
                color: "#ffffff",
                boxShadow: "0 4px 15px rgba(0,0,0,0.3)",
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
              color: "#ffffff",
              textDecoration: "none",
              padding: "16px 28px",
              borderRadius: "10px",
              fontWeight: "bold",
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
              background: "#16a34a",
              color: "#ffffff",
              textDecoration: "none",
              padding: "16px 28px",
              borderRadius: "10px",
              fontWeight: "bold",
              fontSize: "18px",
            }}
          >
            GitHub Repository
          </a>
        </div>

        <div
          style={{
            marginTop: "80px",
            textAlign: "center",
            color: "#94a3b8",
            fontSize: "18px",
          }}
        >
          Developed by Pragya Dwivedi
        </div>
      </div>
    </div>
  );
}

export default App;