import { Item } from 'core/item'
import { FetchGateway } from './gateway'

const getAllItems = async (fetch: typeof window.fetch): Promise<Item[]> => {
  const url = 'http://localhost:5000/inventory'
  const response = await fetch(url, {
    method: 'GET',
    mode: 'no-cors',
  })
  const items = await response.json()
  return items
}

export class ApiClient implements FetchGateway {
  public constructor(private fetch: typeof window.fetch) {}
  getAllItems = () => getAllItems(this.fetch)
}
