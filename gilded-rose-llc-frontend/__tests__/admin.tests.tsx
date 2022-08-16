import { render, screen } from '@testing-library/react'
import '@testing-library/jest-dom'
import Admin from '../pages/admin'

describe('Admin', () => {
  it('should render the name, quality, sellin, and price of each item on the page', () => {
    const items = [
      {
        name: 'aged brie',
        quality: '13',
        sellIn: '29',
        price: '100',
      },
      {
        name: 'conjured',
        quality: '12',
        sellIn: '25',
        price: '50',
      },
    ]
    render(<Admin items={items} />)

    items.forEach((item) => {
      expect(screen.getByText(item.name)).toBeInTheDocument()
      expect(screen.getByText(item.quality)).toBeInTheDocument()
      expect(screen.getByText(item.sellIn)).toBeInTheDocument()
      expect(screen.getByText('$' + item.price)).toBeInTheDocument()
    })
  })

  it('should render the update button', () => {
    render(<Admin items={[]} />)

    const updateButton = screen.getByRole('button', { name: /update quality/i })

    expect(updateButton).toBeInTheDocument()
  })
})
