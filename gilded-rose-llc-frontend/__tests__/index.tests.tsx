import { render, screen } from "@testing-library/react";
import '@testing-library/jest-dom'
import Home from "../pages/index";

describe("Home", () => {
  it("should render a heading of Gilded Rose", () => {
    render(<Home items={[]}/>);

    const heading = screen.getByRole('heading', { name: /Gilded Rose/i });
    expect(heading).toBeInTheDocument()
  });
});
