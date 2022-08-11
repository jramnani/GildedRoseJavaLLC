interface ItemBlockProps {
  name: string
  price: string
}

const ItemBlock = ({ name, price }: ItemBlockProps) => {
  return (
    <div className="box-border px-10 py-3 bg-[#8690F4] flex flex-col items-center p-5 justify-between">
      <p className="text-[24px] font-roboto text-center">{name}</p>
      <p className="text-[16px] font-roboto font-semibold text-center">
        {price}
      </p>
      <button className="text-[16px] font-roboto font-semibold border-solid border-2 rounded-[5px] min-w-fit">
        add to cart
      </button>
    </div>
  )
}

export default ItemBlock
