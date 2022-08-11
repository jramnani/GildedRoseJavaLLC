import type { NextPage } from 'next'
import { GetServerSideProps } from 'next'
import ItemBlock from 'components/item-block'
import { Item } from 'core/item'
import * as api from 'core/client'

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
    <div className="bg-[#222C40] text-white w-full h-full">
      <div className="flex-col w-4/5">
        <div className="text-[40px] font-roboto">Gilded Rose</div>
        <p className="">available items</p>
        <div className="">
          <section className="grid grid-cols-3 gap-4">
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
