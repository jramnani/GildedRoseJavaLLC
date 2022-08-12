import type { NextPage } from 'next'
import { GetServerSideProps } from 'next'
import ItemBlock from 'components/item-block'
import { Item } from 'core/item'
import * as api from 'core/client'
import Image from 'next/image'
import logo from 'asset/images/logo.svg'

export const getServerSideProps: GetServerSideProps = async () => {
  const gateway = new api.ApiClient(fetch)
  const items = await gateway.getAllItems()
  return { props: { items } }
}

interface HomeProps {
  items: Item[]
}

const Home: NextPage<HomeProps> = ({ items }) => {
  return (
    <div className="box-border px-14 pt-5 pb-10 items-center justify-between bg-[#222C40] text-white w-full h-full">
      <div className="flex-col">
        <div className="items-center flex pt-10 pb-14 text-[40px] font-roboto font-[700]">
          <div className="h-20 w-24">
            <Image src={logo} alt="gilded rose logo" />
          </div>
          <h1 className="pl-4">gilded rose</h1>
        </div>
        <p className="pt-8 pb-12 text-[32px] font-roboto font-[600]">
          available items
        </p>
        <div className="">
          <section className="grid grid-cols-3 gap-x-6 gap-y-8">
            {items.map((item, index) => (
              <ItemBlock key={index} name={item.name} price={item.price} />
            ))}
          </section>
        </div>
      </div>
    </div>
  )
}

export default Home
