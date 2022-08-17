import { Item } from 'core/item'

export interface ItemGateway {
  getAllItems(): Promise<Item[]>
  updateAllItems(): Promise<Item[]>
}
