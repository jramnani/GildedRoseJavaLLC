import { createContext, ReactNode, useContext } from 'react'
import { ApiClient } from 'core/client'

const GatewayContext = createContext({} as ApiClient)

export const createClient = () => {
  return new ApiClient(fetch)
}

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
