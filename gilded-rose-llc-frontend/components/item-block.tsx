interface ItemBlockProps {
  name: string
  price: string
}

const ItemBlock = ({ name, price }: ItemBlockProps) => {
  return (
    <li className="bg-[#8690F4] my-2">
      <h2>{name}</h2>
      <h3>{price}</h3>
      <button>add to cart</button>
    </li>
  )
}

export default ItemBlock
