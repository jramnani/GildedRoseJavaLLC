import Header from 'components/header'
import { PropsWithChildren } from 'react'

const Layout = ({ children }: PropsWithChildren) => (
    <div className="box-border px-14 pt-5 pb-10 bg-[#222C40] text-white min-h-screen flex-col">
        <Header />
        {children}
    </div>
)

export default Layout