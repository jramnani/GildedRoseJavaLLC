import { PropsWithChildren } from 'react'

const Title = ({ children }: PropsWithChildren) => (
    <h2 className="pt-8 pb-12 text-[32px] font-roboto font-[600]">
        {children}
    </h2>
)

export default Title