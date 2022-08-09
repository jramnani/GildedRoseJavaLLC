import { createContext, useContext } from 'react'
import * as api from 'core/client'

const Context = createContext({})

export const createClient = () => {
  return new api.ApiClient(fetch)
}

export const useClient = () => useContext(Context)

export const ApiProvider = ({ client, children }: any) => {
  const [credentials, setCredentials] = useState({})

  return (
    <Context.Provider value={{ client, credentials, setCredentials }}>
      {children}
    </Context.Provider>
  )
}

const Login = () => {
  const { credentials, setCredentials } = useClient()
  const handleSubmit = () => {
    setCredentials({ token: 'foo' })
  }

  return (
    <div>
      {credentials.token ? (
        <AuthenticatedView>bl;ah</AuthenticatedView>
      ) : (
        <form onSubmit={handleSubmit}>
          <input />
          <input type="text" />
          <button></button>
        </form>
      )}
    </div>
  )
}
