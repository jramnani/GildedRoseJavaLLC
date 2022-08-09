import { Item } from 'core/item'
import { FetchGateway } from './gateway'

const getAllItems = async (fetchMethod: typeof fetch): Promise<Item[]> => {
  const url = 'http://localhost:5000/inventory'
  const response = await fetchMethod(url, {
    method: 'GET',
    mode: 'no-cors',
  })
  const items = await response.json()
  return items
}

export class ApiClient implements FetchGateway {
  public constructor(private fetchMethod: typeof fetch) {}
  getAllItems = () => getAllItems(this.fetchMethod)
}
