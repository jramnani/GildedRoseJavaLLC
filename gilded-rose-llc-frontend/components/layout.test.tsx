import { render, screen } from '@testing-library/react'
import '@testing-library/jest-dom'
import Layout from '../components/layout'

describe('Layout', () => {
    it('should render a heading of Gilded Rose', () => {
        render(<Layout />)

        const heading = screen.getByRole('heading', { name: /Gilded Rose/i })

        expect(heading).toBeInTheDocument()
    })
})