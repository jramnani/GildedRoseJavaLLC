import { render, screen } from '@testing-library/react'
import '@testing-library/jest-dom'
import Admin from '../pages/admin'

describe('Admin', () => {
  it('should render a sub-heading of admin inventory', () => {
    render(<Admin initialItems={[]} />)

    const heading = screen.getByRole('heading', {
      level: 2,
      name: 'admin // inventory',
    })

    expect(heading).toBeInTheDocument()
  })

  it('should render the name, quality, sellin, and price of each item on the page', () => {
    const items = [
      {
        id: '1',
        name: 'aged brie',
        quality: '13',
        sellIn: '29',
        price: '100',
      },
      {
        id: '2',
        name: 'conjured',
        quality: '12',
        sellIn: '25',
        price: '50',
      },
    ]
    render(<Admin initialItems={items} />)

    items.forEach((item) => {
      expect(screen.getByText(item.name)).toBeInTheDocument()
      expect(screen.getByText(item.quality)).toBeInTheDocument()
      expect(screen.getByText(item.sellIn)).toBeInTheDocument()
      expect(screen.getByText('$' + item.price)).toBeInTheDocument()
    })
  })

  it('should render the update button', () => {
    render(<Admin initialItems={[]} />)

    const updateButton = screen.getByRole('button', { name: /update quality/i })

    expect(updateButton).toBeInTheDocument()
  })
})
