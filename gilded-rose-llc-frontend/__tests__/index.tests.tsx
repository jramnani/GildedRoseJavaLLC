import { render, screen } from '@testing-library/react'
import '@testing-library/jest-dom'
import Home from '../pages/index'

describe('Home', () => {
  it('should render a sub-heading of admin inventory', () => {
    render(<Home items={[]} />)

    const heading = screen.getByRole('heading', {
      level: 2,
      name: 'available items',
    })

    expect(heading).toBeInTheDocument()
  })

  it('should render the name and price of each item on the page', () => {
    const items = [
      {
        id: '1',
        name: 'aged brie',
        price: '100',
      },
      {
        id: '2',
        name: 'conjured',
        price: '50',
      },
    ]
    render(<Home items={items} />)

    items.forEach((item) => {
      expect(screen.getByText(item.name)).toBeInTheDocument()
      expect(screen.getByText('$' + item.price)).toBeInTheDocument()
    })
  })
})
