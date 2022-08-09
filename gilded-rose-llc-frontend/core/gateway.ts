import { Item } from 'core/item'

export interface FetchGateway {
  getAllItems(): Promise<Item[]>
}
