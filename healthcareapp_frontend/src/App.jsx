import { Navigate, Route, Routes } from 'react-router-dom'
import './App.css'
import HealthcarePortal from './components/HealthcarePortal'

function App() {
  return (
    <div className="app-shell">
      <Routes>
        <Route path="/*" element={<HealthcarePortal />} />
        <Route path="*" element={<Navigate to="/patients/add" replace />} />
      </Routes>
    </div>
  )
}

export default App
