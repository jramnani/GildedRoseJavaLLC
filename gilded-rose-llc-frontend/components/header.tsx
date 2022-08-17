import Image from 'next/image'
import logo from 'asset/images/logo.svg'

const Header = () => (
  <div className="items-center flex pt-10 pb-14 text-[40px] font-roboto font-[700]">
    <div className="h-20 w-24">
      <Image src={logo} alt="gilded rose logo" />
    </div>
    <h1 className="pl-4 lowercase">Gilded Rose</h1>
  </div>
)

export default Header