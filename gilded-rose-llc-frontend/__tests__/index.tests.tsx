import { render, screen } from '@testing-library/react'
import '@testing-library/jest-dom'
import Home from '../pages/index'
import { Item } from '../core/item'
import { ApiProvider } from '../core/api'
import { ApiClient } from 'core/client'

describe('Home', () => {
  it('should render a sub-heading of admin inventory', () => {
    render(<Home items={[]} />)

    const heading = screen.getByRole('heading', {
      level: 2,
      name: 'available items',
    })

    expect(heading).toBeInTheDocument()
  })

  const fetch = jest.fn()
  const client = new ApiClient(fetch)

  const mockClient = (fetchMethod: typeof fetch) => ({
    getAllItems: jest.fn(() => Promise.resolve(items)),
    updateAllItems: jest.fn(() => Promise.resolve(items)),
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
    const client = mockClient(items)

    render(
      <ApiProvider client={client}>
        <Home />
      </ApiProvider>
    )

    items.forEach((item) => {
      expect(screen.getByText(item.name)).toBeInTheDocument()
      expect(screen.getByText('$' + item.price)).toBeInTheDocument()
    })
  })
})
