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
    <div className="bg-[#222C40] min-h-screen text-white">
      <h1>Gilded Rose</h1>
      <ul>
        {/* TODO: Will replace the index below with an id located in the items array */}
        {items.map((item, index) => (
          <ItemBlock key={index} name={item.name} price={item.price} />
        ))}
      </ul>
    </div>
  )
}

export default Home
