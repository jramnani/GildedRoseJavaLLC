import type { NextPage } from 'next'
import { GetServerSideProps } from 'next'
import ItemBlock from 'components/item-block'

const getRequest = async () => {
  const url = 'http://localhost:5000/inventory'
  const response = await fetch(url, {
    method: 'GET',
    mode: 'no-cors',
  })
  return response
}

export const getServerSideProps: GetServerSideProps = async () => {
  const res = await getRequest()
  const items = await res.json()
  return { props: { items } }
}

interface HomeProps {
  items: Item[]
}

interface Item {
  name: string
  price: string
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
