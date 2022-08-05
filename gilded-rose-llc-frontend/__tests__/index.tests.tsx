import { render, screen } from "@testing-library/react";
import Home from "../pages/index";

describe("Home", () => {
  it("should render a heading of Gilded Rose", () => {
    render(<Home items={[]}/>);
    const expectedHeading = "Gilded Rose"

    const heading = (screen.getByRole('heading', {name: /Bubba gump shrimp/i}))
    expect(heading).toBeInTheDocument();
  });
});
