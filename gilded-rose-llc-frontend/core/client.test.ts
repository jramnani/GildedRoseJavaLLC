import * as sut from 'core/client'

describe('ApiClient', () => {
  describe('#getAllItems', () => {
    it('performs a GET request to the gilded rose api', () => {
      const fetch = jest.fn()
      const client = new sut.ApiClient(fetch)
      fetch.mockResolvedValue({ status: 200, json: async () => [] })

      client.getAllItems()

      expect(fetch).toHaveBeenCalledTimes(1)
      expect(fetch).toHaveBeenCalledWith('http://localhost:5000/inventory', {
        method: 'GET',
        mode: 'no-cors',
      })
    })

    it('should perform a POST request to the gilded rose api /inventory/update resource', () => {
      const fetch = jest.fn()
      const client = new sut.ApiClient(fetch)
      fetch.mockResolvedValue({ status: 200, json: async () => [] })

      client.updateAllItems()

      expect(fetch).toHaveBeenCalledTimes(1)
      expect(fetch).toHaveBeenCalledWith(
        'http://localhost:5000/inventory/update',
        {
          method: 'POST',
        }
      )
    })
  })
})
