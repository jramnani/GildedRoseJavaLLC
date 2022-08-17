import { Item } from 'core/item'
import { ItemGateway } from './gateway'

const getAllItems = async (fetchMethod: typeof fetch): Promise<Item[]> => {
  const url = 'http://localhost:5000/inventory'
  const response = await fetchMethod(url, {
    method: 'GET',
    mode: 'no-cors',
  })
  const items = await response.json()
  return items
}

const updateAllItems = async (fetchMethod: typeof fetch): Promise<Item[]> => {
  const url = 'http://localhost:5000/inventory/update'
  const response = await fetchMethod(url, {
    method: 'POST',
  })
  const items = await response.json()
  return items
}

export class ApiClient implements ItemGateway {
  public constructor(private fetchMethod: typeof fetch) {}
  getAllItems = () => getAllItems(this.fetchMethod)
  updateAllItems = () => updateAllItems(this.fetchMethod)
}
