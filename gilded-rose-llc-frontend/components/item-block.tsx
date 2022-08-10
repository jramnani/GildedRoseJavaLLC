interface ItemBlockProps {
  name: string
  price: string
}

const ItemBlock = ({ name, price }: ItemBlockProps) => {
  return (
    <div className="bg-[#8690F4] m-5 h-[180px] w-[342px">
      <p className="text-[24px] font-roboto items-center justify-center">
        {name}
      </p>
      <p className="text-[16px] font-roboto font-semibold">{price}</p>
      <button>add to cart</button>
    </div>
  )
}

export default ItemBlock
