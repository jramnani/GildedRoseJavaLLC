interface ItemBlockProps {
  name: string
  price: string
}

const ItemBlock = ({ name, price }: ItemBlockProps) => {
  return (
    <div className="bg-[#8690F4] flex-col content-center justify-center w-[300px] h-[500px]">
      <div className="text-[24px] font-roboto ">{name}</div>
      <div className="text-[16px] font-roboto font-semibold">{price}</div>

      <button className="text-[16px] font-roboto font-semibold border-solid border-2 rounded-[5px]">
        add to cart
      </button>
    </div>
  )
}

export default ItemBlock
