import { createContext, ReactNode, useContext } from 'react'
import { ApiClient } from 'core/client'

// Create default context of {}
const GatewayContext = createContext({} as ApiClient)

// This creates the instance of the Gateway
export const createClient = () => {
  return new ApiClient(fetch)
}

//This function will use the context that is set in GatewayContext
export const useClient = () => useContext(GatewayContext)

type ApiProviderProps = {
  client: ApiClient
  children: ReactNode
}

export const ApiProvider = ({ client, children }: ApiProviderProps) => {
  return (
    <GatewayContext.Provider value={client}>{children}</GatewayContext.Provider>
  )
}
