import type { NextPage } from "next";
import Head from "next/head";

interface ItemBlockProps {
  name: string;
  price: string;
}

const ItemBlock = (props: ItemBlockProps) => {
  return (
    <li className="bg-[#8690F4] my-2">
      <h2>{props.name}</h2>
      <h3>{props.price}</h3>
      <button>add to cart</button>
    </li>
  );
};

const Home: NextPage = () => {
  const items = [
    {
      name: "Item Name",
      price: "$10000000.00",
    },
    {
      name: "Another Name",
      price: "$2000000.00",
    },
    {
      name: "My Bank Account",
      price: "$0.01",
    },
  ];
  return (
    <div className="bg-[#222C40] min-h-screen text-white">
      <h1>GILDED ROSE RULEZ</h1>
      <ul>
        {items.map((item) => (
          <ItemBlock key={item.name} name={item.name} price={item.price} />
        ))}
      </ul>
    </div>
  );
};

export default Home;
