import { render, screen } from "@testing-library/react";
import Home from "../pages/index";

describe("Home", () => {
  it("should pass this test meaning that the testing framework is working", () => {
    render(<Home />);

    screen.debug();
  });
});
