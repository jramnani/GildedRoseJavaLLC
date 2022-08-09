import { render, screen } from '@testing-library/react'
import '@testing-library/jest-dom'
import Home from '../pages/index'
import { ApiProvider } from 'components/api'

describe('Home', () => {
  const mockClient = (items) => ({
    getAllItems: jest.fn(() => Promise.resolve(items)),
  })

  it('should render an empty message when no items', () => {
    const client = mockClient([])

    render(
      <ApiProvider client={client}>
        <Home />
      </ApiProvider>
    )

    const message = screen.getByText('No items')

    expect(message).toBeInTheDocument()
  })

  it('should render an empty message when no items', () => {
    const client = mockClient([{ name, price }])

    render(
      <ApiProvider client={client}>
        <Home />
      </ApiProvider>
    )

    const message = screen.getByText('No items')

    expect(message).toBeInTheDocument()
  })

  it('should render a heading of Gilded Rose', () => {
    render(
      <ApiProvider client={mockClient}>
        <Home items={[]} />
      </ApiProvider>
    )

    const heading = screen.getByRole('heading', { name: /Gilded Rose/i })
    expect(heading).toBeInTheDocument()
  })

  it('should render all of the items on the page', () => {
    const items = [
      {
        name: 'aged brie',
        price: '100',
      },
      {
        name: 'conjured',
        price: '50',
      },
    ]
    render(<Home items={items} />)
    const renderedItems = screen.getAllByRole('listitem')

    expect(renderedItems.length).toEqual(items.length)
  })

  it('should render the name and price of each item on the page', () => {
    const items = [
      {
        name: 'aged brie',
        price: '100',
      },
      {
        name: 'conjured',
        price: '50',
      },
    ]
    render(<Home items={items} />)

    items.forEach((item) => {
      expect(screen.getByText(item.name)).toBeInTheDocument()
      expect(screen.getByText(item.price)).toBeInTheDocument()
    })
  })
})
