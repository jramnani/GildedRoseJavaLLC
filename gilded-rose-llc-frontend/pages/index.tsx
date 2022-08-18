import type { NextPage } from 'next'
import { GetServerSideProps } from 'next'
import ItemBlock from 'components/item-block'
import { Item } from 'core/item'
import * as api from 'core/client'
import Title from 'components/title'

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
    <>
      <Title>available items</Title>
      <div>
        <section className="grid grid-cols-3 gap-x-6 gap-y-8">
          {items.map((item) => (
            <ItemBlock key={item.id} name={item.name} price={item.price} />
          ))}
        </section>
      </div>
    </>
  )
}

export default Home
