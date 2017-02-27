# Define the Application Filters Module
numberFilters = angular.module 'numberFilters', []

# Define the GreetingListController Controller
numberFilters.filter 'base', ->
  someting = (input, base) ->
    parsed = parseInt(input, 10)
    based = parseInt(base, 10)
    #isNaN is not isNan
    if (isNaN(parsed) || isNaN(based))
      # body...
      ""
    else if based <= 1 || based >= 36
      # body...
      "based must be between 2 - 36"
    else
      # body...
      parsed.toString(based)
    # 0
