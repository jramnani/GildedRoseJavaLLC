import type { NextPage } from 'next'
import { GetServerSideProps } from 'next'
import * as api from 'core/client'
import Image from 'next/image'
import logo from 'asset/images/logo.svg'

export const getServerSideProps: GetServerSideProps = async () => {
  const gateway = new api.ApiClient(fetch)
  const items = await gateway.getAllItems()
  return { props: { items } }
}

interface AdminItem {
  name: string
  quality: string
  sellIn: string
  price: string
}

interface AdminProps {
  items: AdminItem[]
}

const Admin: NextPage<AdminProps> = ({ items }) => {
  return (
    <div className="box-border px-14 pt-5 pb-10 bg-[#222C40] text-white min-h-screen">
      <div className="flex-col">
        <div className="items-center flex pt-10 pb-14 text-[40px] font-roboto font-[700]">
          <div className="h-20 w-24">
            <Image src={logo} alt="gilded rose logo" />
          </div>
          <h1 className="pl-4 lowercase">Gilded Rose</h1>
        </div>
        <p className="pt-8 pb-12 text-[32px] font-roboto font-[600]">
          admin // inventory
        </p>
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
            <button className='whitespace-nowrap py-[15px] px-[26px] lowercase bg-[#8690F4] rounded-[7px] text-[#222C40] font-medium'>Update Quality</button>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Admin
