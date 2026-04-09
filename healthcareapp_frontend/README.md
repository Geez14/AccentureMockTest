# HealthcareApp Frontend

React + Vite frontend for Patient and Appointment modules.

## Prerequisites

- Node.js (v16 or newer)
- npm
- Spring Boot backend running on port `8090`

## How To Run

1. Open terminal in the project folder.
2. Install dependencies:

```bash
npm.cmd install
```

3. Start the frontend:

```bash
npm start
```

Alternative start command:

```bash
npm run dev
```

Frontend URL:

```text
http://127.0.0.1:5173/
```

## Build Commands

Build for production:

```bash
npm run build
```

Preview build locally:

```bash
npm run preview
```

## Backend Configuration

Default backend base URL used by frontend:

```text
http://localhost:8090
```

To change backend URL on Windows PowerShell:

```powershell
$env:VITE_API_BASE_URL = "http://localhost:8090"
npm start
```

To change backend URL on Windows CMD:

```cmd
set VITE_API_BASE_URL=http://localhost:8090
npm start
```

## Pages And Endpoints

- Add Patient -> POST `/patients/save`
- Get Patients -> GET `/patients/list`
- Add Appointment -> POST `/appointments/save`
- Get Appointments -> GET `/appointments/list`

## Form Field Mapping

Patient form fields:

- `patientName`
- `age`
- `gender`
- `contactNumber`

Appointment form fields:

- `appointmentDate` (format: `yyyy-MM-dd`)
- `appointmentTime` (format: `HH:mm`)
- `doctorName`
- `status`
- `patient.patientId`

All save requests are sent as `application/x-www-form-urlencoded` to match Spring controller binding.

## Main Files

- `src/App.jsx` - app routes entry
- `src/main.jsx` - React bootstrap with router
- `src/components/HealthcarePortal.jsx` - patient/appointment UI and API integration
- `src/components/HealthcarePortal.css` - styling
