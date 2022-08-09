import '../styles/globals.css'
import type { AppProps } from 'next/app'
import { ApiProvider, createClient } from 'components/api'

function MyApp({ Component, pageProps }: AppProps) {
  const client = createClient()

  return (
    <ApiProvider client={client}>
      <Component {...pageProps} />
    </ApiProvider>
  )
}

export default MyApp
