import type { NextPage } from 'next'
import { GetServerSideProps } from 'next'
import * as api from 'core/client'
import Title from 'components/title'
import { AdminItem } from 'core/admin-item'
import React, { useState } from 'react';

export const getServerSideProps: GetServerSideProps = async () => {
  const gateway = new api.ApiClient(fetch)
  const initialItems = await gateway.getAllItems()
  return { props: { initialItems } }
}

interface AdminProps {
  initialItems: AdminItem[]
}

const Admin: NextPage<AdminProps> = ({ initialItems }) => {
  const [items, setItems] = useState(initialItems)
  const updateItems = async () => {
    const gateway = new api.ApiClient(fetch)
    const items = await gateway.updateAllItems()
    setItems(items)
  }
  return (
    <>
      <Title>admin // inventory</Title>
      <div className='flex gap-x-[102px]'>
        <table className="table-auto border-collapse text-left divide-y-2 divide-[#8690F4]">
          <thead>
            <tr className='flex-row space-x-52'>
              <th className='py-3.5 pl-2 w-96 font-normal lowercase'>Item Name</th>
              <th className='w-52 font-normal lowercase'>Quality</th>
              <th className='w-52 font-normal lowercase'>Sell-In</th>
              <th className='w-28 font-normal lowercase'>Price</th>
            </tr>
          </thead>
          <tbody>
            {items.map((item, index) => (
              <tr key={index} className="border-b-2 border-y-[#8690F4]">
                <td className='py-3.5 pl-2'>{item.name}</td>
                <td>{item.quality}</td>
                <td>{item.sellIn}</td>
                <td>${item.price}</td>
              </tr>
            ))}
          </tbody>
        </table>
        <div>
          <button onClick={updateItems} className='whitespace-nowrap py-[15px] px-[26px] w-40 lowercase bg-[#8690F4] rounded-[7px] text-[#222C40] font-medium'>Update Quality</button>
        </div>
      </div>
    </>
  )
}

export default Admin
