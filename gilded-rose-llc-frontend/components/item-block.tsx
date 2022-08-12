interface ItemBlockProps {
  name: string
  price: string
}

const ItemBlock = ({ name, price }: ItemBlockProps) => {
  return (
    <div className="rounded-[5px] box-border px-10 py-6 h-full space-y-5 bg-[#8690F4] flex flex-col items-center justify-between">
      <p className="text-[24px] font-roboto font-[700] text-center">{name}</p>
      <p className="text-[16px] font-roboto font-[600] text-center">${price}</p>
      <button className="text-[16px] font-roboto font-[600] border-solid border-2 rounded-[5px] py-1 px-3 min-w-fit">
        add to cart
      </button>
    </div>
  )
}

export default ItemBlock
