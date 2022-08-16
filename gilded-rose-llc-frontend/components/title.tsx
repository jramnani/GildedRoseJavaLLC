import { PropsWithChildren } from 'react'

const Title = ({ children }: PropsWithChildren<{}>) => (
    <p className="pt-8 pb-12 text-[32px] font-roboto font-[600]">
        {children}
    </p>
)

export default Title