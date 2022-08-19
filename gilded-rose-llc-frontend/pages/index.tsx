import type { NextPage } from 'next'
import ItemBlock from 'components/item-block'
import { Item } from 'core/item'
import Title from 'components/title'
import { useState } from 'react'
import { useClient } from 'core/api'

const Home: NextPage = () => {
  const [items, setItems] = useState<Item[]>([])
  const client = useClient()

  useState(() => {
    client.getAllItems().then((items) => setItems(items))
  })

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
