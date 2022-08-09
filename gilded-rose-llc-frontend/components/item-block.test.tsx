import ItemBlock from './item-block'
import { render, screen } from '@testing-library/react'
import '@testing-library/jest-dom'

describe('ItemBlock', () => {
  it('Should display the item name', () => {
    const item = {
      name: 'aged brie',
      price: '50',
    }
    render(<ItemBlock name={item.name} price={item.price} />)
    const name = screen.getByText(item.name)

    expect(name).toBeInTheDocument()
  })

  it('Should display the item price', () => {
    const item = {
      name: 'aged brie',
      price: '50',
    }
    render(<ItemBlock name={item.name} price={item.price} />)
    const price = screen.getByText(item.price)

    expect(price).toBeInTheDocument()
  })

  it('Should display an Add to Cart button', () => {
    const item = {
      name: 'aged brie',
      price: '50',
    }
    render(<ItemBlock name={item.name} price={item.price} />)
    const addToCartButton = screen.getByRole('button', { name: /add to cart/i })

    expect(addToCartButton).toBeInTheDocument()
  })
})
