import '../styles/globals.css'
import type { AppProps } from 'next/app'
import Layout from 'components/layout'
import { ApiProvider, createClient } from 'core/api'

function MyApp({ Component, pageProps }: AppProps) {
  const client = createClient()
  return (
    <ApiProvider client={client}>
      <Layout>
        <Component {...pageProps} />
      </Layout>
    </ApiProvider>
  )
}

export default MyApp
