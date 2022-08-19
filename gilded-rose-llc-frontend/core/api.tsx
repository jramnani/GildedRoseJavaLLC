import { createContext, ReactNode, useContext } from 'react'
import { ApiClient } from 'core/client'

const Context = createContext({} as ApiClient)

export const createClient = () => {
  return new ApiClient(fetch)
}

export const useClient = () => useContext(Context)

type ApiProviderProps = {
  client: ApiClient
  children: ReactNode
}

export const ApiProvider = ({ client, children }: ApiProviderProps) => {
  return <Context.Provider value={client}>{children}</Context.Provider>
}
